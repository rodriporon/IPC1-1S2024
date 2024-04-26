import { useEffect, useState } from "react";
import Post from "../components/Post";
import useUserStore from "../hooks/userStore";
import FileUploader from "../components/FileUploader";
import DataTable from "../components/DataTable";

export default function AdminPage() {
  const user = useUserStore((state) => state.user);
  const [posts, setPosts] = useState([]);
  const [jsonData, setJsonData] = useState([]);

  const handleDataLoad = (data) => {
    setJsonData(data);
  };

  const getPosts = async () => {
    try {
      const response = await fetch("http://localhost:3000/api/posts/get");
      if (!response.ok) {
        throw new Error("Error en la peticion");
      }

      const data = await response.json();
      setPosts(data);
    } catch (error) {
      console.error(error);
    }
  };
  useEffect(() => {
    getPosts();
  }, []);

  return (
    <main className="flex justify-center flex-col items-center h-screen gap-10">
      <h1>Administrador - {user}</h1>
      <section>
        <h2>Subir archivo</h2>
        <FileUploader onDataLoad={handleDataLoad} />
        <p>Usuarios cargados</p>
        <DataTable data={jsonData} />
      </section>
      <p>Estos son los posts:</p>
      {posts.map((post) => (
        <Post
          key={post.id}
          name={post.name}
          email={post.email}
          text={post.text}
        />
      ))}
    </main>
  );
}
