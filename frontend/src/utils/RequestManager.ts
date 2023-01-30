import axios, {AxiosError} from 'axios';
import * as readline from "readline";
//import config from '../config';
const config = {
    url: "http://localhost:8082"
}

export default class RequestManager {
    private constructor() { }


    public static async registerRequest(email: string, password: string) {
        return this.request("/auth/register", "POST", undefined,{email, password});
    }

    public static async loginRequest(email: string, password: string) {
        return this.request("/auth/authorize", "POST", undefined,{email, password});
    }

    public static HHTP_METHODS = {
        GET: "GET" as "GET",
        POST: "POST" as "POST"
    }

    private static async request(url: string, method: "GET" | "POST", authorization?: string, data?: object) {
        if (data && method == "GET") throw new Error("sus");
        const headers: object = {
            authorization,
            // "Access-Control-Allow-Origin": "*",
            'Content-Type': 'application/json',
            // 'Access-Control-Allow-Headers':"*",
            // 'Access-Control-Allow-Credentials': true
            "Origin": null
        }
        return await axios.request({
            url: config.url+url,
            method,
            data,
            headers,
        }).catch((r: AxiosError) => null).then(r => r)
    }
}