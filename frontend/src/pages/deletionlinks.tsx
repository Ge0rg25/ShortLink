import style from "../styles/del.module.css"
import React from "react";
import Footer from "@/components/Footer";
export default function Deletionlinks() {
    return (
        <>
            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
                <script src="http://yandex.st/jquery/1.8.2/jquery.min.js"></script>
                <script src="js/jquery.cookie.js"></script>
                <script src="js/core.js"></script>
                <title>DeletionLinks</title>
            </head>
            <header>
                <div className={style.title}><h1>Deletion Links</h1></div>
            </header>
            <body>
            <form action="#">
                <fieldset>
                    <legend>Добавление/удаление ссылок</legend>
                    <div>
                        <label htmlFor="siteLink" className={style.labelLink}>ShortLink: </label><br/>
                        <input name="link" value="" id="siteLink" type="text"/>
                    </div>
                    <div>
                        <br/><input value="Del" type="submit"/>
                    </div>
                    <div>
                        <br/><label htmlFor="siteLink" className={style.labelLink}>LongLink: </label><br/>
                        <input name="link" value="" id="siteLink" type="text"/>
                    </div>
                    <div>
                        <br/><input value="Del" type="submit"/>
                    </div>
                </fieldset>
            </form>
            <Footer></Footer>
            </body>
        </>
    )
}