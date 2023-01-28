import style from "../styles/reg.module.css"
import React from "react";
import Footer from "@/componets/Footer";
export default function Registration() {
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
            <form action="#">
                <fieldset>
                    <legend>Вход в личный кабинет</legend>
                    <div>
                        <label htmlFor="siteLogin" className={style.labelLogin}>Login: </label><br/>
                        <input name="login" value="" id="siteLogin" type="text"/>
                    </div>
                    <div>
                        <label htmlFor="sitePass" className={style.labelPass}>Password: </label><br/>
                        <input name="pass" value="" id="sitePass" type="password"/>
                    </div>
                    <div>
                        <br/><input value="Log in" type="submit"/>
                    </div>
                </fieldset>
            </form>
            <Footer></Footer>
            </body>
        </>
    )
}
