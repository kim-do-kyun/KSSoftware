import React, { useState } from 'react';
import { useForm, SubmitHandler} from "react-hook-form";
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import SignUp from './SignUp'; // SignUp 컴포넌트 import

function LoginHome() {
    const [pwd, setPassword] = useState('');
    const [userId, setUserId] = useState('');
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await axios.post('/signin', {
                pwd,
                userId
            });
            console.log('login successful:', response.data);
            alert(response.data);
            loginSuccess();
            // 로그인 성공 시 추가 처리
        } catch (error) {
            console.error('login failed:', error);
            alert("아이디, 비번 틀림")
            // 로그인 실패 시 에러 처리
        }

        setPassword('');
        setUserId('');
    };

    const loginSuccess = () => {
        navigate('/');
    }

    const handleSignup = () => {
        navigate('/Login/SignUp');
    }

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label htmlFor="userid">Userid:</label>
                <input
                    type="text"
                    id="userid"
                    value={userId}
                    onChange={(e) => setUserId(e.target.value)}
                />
            </div>
            <div>
                <label htmlFor="password">Password:</label>
                <input
                    type="password"
                    id="password"
                    value={pwd}
                    onChange={(e) => setPassword(e.target.value)}
                />
            </div>
            <button type="submit">로그인</button>
            <button type="button" onClick={handleSignup}>회원가입</button>
        </form>
    );
}

export default LoginHome;
