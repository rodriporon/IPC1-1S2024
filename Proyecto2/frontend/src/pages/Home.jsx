import "./Home.css";
import { Link } from "react-router-dom";
import { Button } from "@nextui-org/react";

export default function Home() {
  return (
    <main className="h-screen flex flex-col justify-center items-center">
      <header>
        <h1 className="text-center font-bold text-4xl">USocial</h1>
        <div className="flex justify-center">
          <img
            src="https://aula.becat.online/pluginfile.php/76459/mod_forum/post/39020/foro%20%281%29.png"
            alt="Logo del foro"
            className="w-1/3 h-auto"
          />
        </div>
        <p>
          Bienvenido a nuestra plataforma dedicada a crear un sitio de foros
          ideal para los estudiantes.
        </p>
      </header>
      <section className="flex flex-col items-center my-4">
        <div className="flex flex-col items-center">
          <h2 className="font-bold">Contacto de soporte</h2>
          <p>rodriporon2@gmail.com</p>
        </div>
        <div className="flex gap-5 my-5">
          <Link to="/login">
            <Button color="primary">Iniciar Sesion</Button>
          </Link>
          <Button color="secondary">Registrarse</Button>
        </div>
      </section>
      <footer className="flex gap-6">
        <p>Rodrigo Antonio Poron De Leon</p>
        <p>201902781</p>
      </footer>
    </main>
  );
}
