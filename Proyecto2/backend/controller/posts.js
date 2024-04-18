let posts = [
    {
        id: 1,
        userId: 2,
        name: "Rodrigo",
        email: "rodriporon2@gmail.com",
        text: "Este es un post"
    },
    {
        id: 2,
        userId: 2,
        name: "Rodrigo",
        email: "rodriporon2@gmail.com",
        text: "Este es un nuevo post"
    }
]

export const getPosts = (req, res) => {
    return res.status(200).json(posts);
}
