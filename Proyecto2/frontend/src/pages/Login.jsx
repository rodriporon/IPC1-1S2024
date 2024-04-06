import { Input, Button } from "@nextui-org/react";
import { useState } from "react";

export default function Login() {
  const [formData, setFormData] = useState({ email: "", password: "" });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Aqui puedes hacer la peticion a tu API
    try {
      const response = await fetch("http://localhost:3000/api/auth/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        alert("Error en la peticion");
        throw new Error("Error en la peticion");
      }

      const data = await response.json();
      alert("Inicio de sesion exitoso");
      console.log({ data });
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <main className="flex justify-center flex-col items-center h-screen">
      <div className="my-8">
        <h1 className="font-bold text-lg">Iniciar Sesion</h1>
      </div>
      <div>
        <form
          onSubmit={handleSubmit}
          className="flex gap-8 justify-center items-center"
        >
          <Input
            type="email"
            label="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            autoComplete="off"
            placeholder="correo@example.com"
          />
          <Input
            type="password"
            label="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
          />
          <Button type="submit" color="success">
            Login
          </Button>
        </form>
      </div>
    </main>
  );
}
