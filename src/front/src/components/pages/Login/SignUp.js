import React, { useState } from 'react';
import { useForm, SubmitHandler} from "react-hook-form";
import axios from 'axios';

function SignUp() {
    const [userName, setUsername] = useState('');
    const [pwd, setPassword] = useState('');
    const [userId, setUserId] = useState('');
    const [userNum, setUserNum] = useState('');
    const [isDuplicated, setIsDuplicated] = useState(false);

    const handleSubmit = async (event) => {
        event.preventDefault();
        if (!isDuplicated) {
            alert('아이디 중복 확인 먼저 진행하셈')
            return;
        }
        try {
            const response = await axios.post('/signup', {
                userName,
                pwd,
                userId,
                userNum: parseInt(userNum)
            });
            console.log('join successful:', response.data);
            alert(response.data);
            // 로그인 성공 시 추가 처리
        } catch (error) {
            console.error('join failed:', error);
            // 로그인 실패 시 에러 처리
        }

        setUsername('');
        setPassword('');
        setUserId('');
        setUserNum('');
        setIsDuplicated(false);
    };

    // 아이디 중복 체크 확인
    const duplicateUserId = async (event) => {
        event.preventDefault();
        try{
            const response = await axios.post('/checkid', {
                userId
            });
            if(response.data === "사용가능한 아이디"){
                alert(response.data);
                setIsDuplicated(true);
            }
        }catch (error) {
            console.error('사용 불가능한 아이디', error);
            alert("사용불가능한아이디");
        }
        // setUserId();
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
                <button type="button" onClick={duplicateUserId}>아이디 중복 확인</button>
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
            <div>
                <label htmlFor="username">Username:</label>
                <input
                    type="text"
                    id="username"
                    value={userName}
                    onChange={(e) => setUsername(e.target.value)}
                />
            </div>
            <div>
                <label htmlFor="usernum">Usernum:</label>
                <input
                    type="text"
                    id="usernum"
                    value={userNum}
                    onChange={(e) => setUserNum(e.target.value)}
                />
            </div>
            <button type="submit">회원가입</button>
        </form>
    );
}

export default SignUp;
