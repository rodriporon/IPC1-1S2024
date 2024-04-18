import { useEffect, useState } from "react";
import Post from "../components/Post";

export default function AdminPage() {
  const [posts, setPosts] = useState([]);

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
      <h1>Administrador</h1>
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
