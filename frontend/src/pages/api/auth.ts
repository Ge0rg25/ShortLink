import { NextApiRequest, NextApiResponse } from "next";

export default async function handler(
    req: NextApiRequest,
    res: NextApiResponse
) {
    if (!req.query.auth) return res.status(403).send("");
    res.setHeader("Set-Cookie", `authorization=${req.query.auth}`);
    return res.redirect("/");
}