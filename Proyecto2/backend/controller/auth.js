let users = [{
    email: "rodriporon2@gmail.com",
    password: "123456"
}]

export const login = (req, res) => {
    console.log("entro al endpoint")
    const { email, password } = req.body;

    const user = users.find(user => user.email === email && user.password === password);

    if (!user) {
        return res.status(401).json({ message: "Invalid credentials" });
    }

    return res.status(200).json({ message: "Login success"});
}

export const register = (req, res) => {
    const { email, password } = req.body;

    const user = users.find(user => user.email === email);

    if (user) {
        return res.status(401).json({ message: "User already exists" });
    }

    users.push({ email, password });

    return res.status(200).json({ message: "User created" });
}