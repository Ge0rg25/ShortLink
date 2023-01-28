import style from "../styles/home.module.css"
import React from "react";
import Footer from "../components/Footer";
export default function Home() {
    return (
        <>
          <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
              <script src="http://yandex.st/jquery/1.8.2/jquery.min.js"></script>
              <script src="js/jquery.cookie.js"></script>
              <script src="js/core.js"></script>
              <title>Short</title>
          </head>
            <header>
                <div className={style.title}><h1>Short</h1></div>
            </header>
          <body>
          <div className={style.topmenu}>
              <div className={style.user}>
                  Login/Registration
              </div>
              <div className={style.text}><h1>ваивив</h1></div>
          </div>
          <Footer></Footer>
          </body>

        </>
    )
}
