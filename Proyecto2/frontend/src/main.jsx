import React from "react";
import ReactDOM from "react-dom/client";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Administrador from "./pages/Admin";
import "./index.css";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/foro",
    element: <h1>Página para mostrar los foros</h1>,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/admin",
    element: <Administrador />,
  },
  {
    path: "/user",
    element: <h1>Usuario</h1>,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <main className="dark text-foreground bg-background">
      <RouterProvider router={router} />
    </main>
  </React.StrictMode>
);
