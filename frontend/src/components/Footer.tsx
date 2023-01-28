import style from "@/styles/home.module.css";

export default function Footer() {
    return(
        <>
            <footer>
                <div className={style.adress}>
                    <b>Telegram: </b>
                    <address>@antonov_dmitriy</address>
                </div>
            </footer>
        </>
    )
}