import express from "express";
import bodyParser from "body-parser";
import authRoutes from "./routes/auth.js";
import postsRoutes from "./routes/posts.js";
import cors from "cors";


const app = express()

// Middleware bodyParser que permite leer los datos que vienen en el body de las peticiones
app.use(bodyParser.json()) // para peticiones application/json

// Middleware para habilitar CORS
app.use(cors())

app.use("/api/auth", authRoutes) // http://localhost:3000/api/auth/login
app.use("/api/posts", postsRoutes) // http://localhost:3000/api/posts/get

const PORT = 3000

app.listen(PORT, () => {
    console.log(`Server is running on port ${PORT}`)
})