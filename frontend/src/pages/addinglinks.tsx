import style from "../styles/add.module.css"
import React from "react";
import Footer from "@/components/Footer";
export default function Addinglinks() {
    return (
        <>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
                <script src="http://yandex.st/jquery/1.8.2/jquery.min.js"></script>
                <script src="js/jquery.cookie.js"></script>
                <script src="js/core.js"></script>
                <title>AddingLinks</title>
            </head>
            <header>
                <div className={style.title}><h1>Adding Links</h1></div>
            </header>
            <body>
            <form action="#">
                <fieldset>
                    <legend>Добавление/удаление ссылок</legend>
                    <div>
                        <input value="Add" type="submit"/>
                    </div>
                    <div>
                        <br/><label htmlFor="siteLink" className={style.labelLink}>Insert link: </label><br/>
                        <input name="link" value="" id="siteLink" type="text"/>
                    </div>
                </fieldset>
            </form>
            <Footer></Footer>
            </body>
        </>
    )
}