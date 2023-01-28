import style from "../styles/reg.module.css"
import React, {useEffect, useImperativeHandle, useRef} from "react";
import Footer from "@/components/Footer";
export default function Login() {

    // @ts-ignore
    useEffect(()=>{
        (document.getElementById("login") as HTMLButtonElement)
            .addEventListener("click", (e)=>{
                fetch("http://localhost:8082/auth/register", {
                    method: "POST",
                    // @ts-ignore
                    body: {
                        email: (document.getElementById("siteLogin")as HTMLInputElement).value,
                        password: (document.getElementById("sitePass") as HTMLInputElement).value
                    },
                    headers: {
                        "Content-Type":"application/json"
                    }
                })
        })
    })

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
                        <label htmlFor="siteLogin" className={style.labelLogin}>Login: </label><br/>
                        <input  name="login" value="" id="siteLogin" type="text"/>
                    </div>
                    <div>
                        <label htmlFor="sitePass" className={style.labelPass}>Password: </label><br/>
                        <input  name="pass" value="" id="sitePass" type="password"/>
                    </div>
                    <div>
                        <br/><button  id={"login"}>Войти</button>
                        <button id={"reg"}>Зарегистрироваться</button>
                    </div>
                </fieldset>
            <Footer/>
            </body>
        </>
    )
}
