import style from "../styles/reg.module.css"
import React, {useEffect, useImperativeHandle, useRef} from "react";
import Footer from "@/components/Footer";
import RequestManager from "@/utils/RequestManager";
export default function Login() {
    return (
        <>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
                <script src="http://yandex.st/jquery/1.8.2/jquery.min.js"></script>
                <script src="js/jquery.cookie.js"></script>
                <script src="js/core.js"></script>
                <title>Registration</title>
            </head>
            <header>
                <div className={style.title}><h1>Login/Registration</h1></div>
            </header>
            <body>
            <fieldset>
                    <legend>Вход в личный кабинет</legend>
                    <div>
                        <label htmlFor="siteLogin" className={style.labelLogin}>Почта: </label><br/>
                        <input id="siteLogin" type="text"/>
                    </div>
                    <div>
                        <label htmlFor="sitePass" className={style.labelPass}>Пароль: </label><br/>
                        <input id="sitePass" type="password"/>
                    </div>
                    <div>
                        <br/><button onClick={
                        ((event => {
                            event.preventDefault();
                            const email: HTMLInputElement = event.view.document.getElementById("siteLogin") as HTMLInputElement;
                            const pass: HTMLInputElement = event.view.document.getElementById("sitePass") as HTMLInputElement;
                            RequestManager.loginRequest(email.value, pass.value).then(r=>{
                                console.log(r?.data);
                            }).catch(console.log);
                        }))
                    } id={"login"}>Войти</button>
                        <button onClick={
                            ((event => {
                                event.preventDefault();
                                const email: HTMLInputElement = event.view.document.getElementById("siteLogin") as HTMLInputElement;
                                const pass: HTMLInputElement = event.view.document.getElementById("sitePass") as HTMLInputElement;
                                RequestManager.registerRequest(email.value, pass.value).then(r=>{
                                    console.log(r?.data);
                                }).catch(console.log);
                        }) )
                        } id={"reg"}>Зарегистрироваться</button>
                    </div>
                </fieldset>
            <Footer/>
            </body>
        </>
    )
}
