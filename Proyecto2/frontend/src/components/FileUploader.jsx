export default function FileUploader({ onDataLoad }) {
  const handleFileChange = (event) => {
    const selectedFile = event.target.files[0];
    const reader = new FileReader();
    reader.onload = (e) => {
      const data = JSON.parse(e.target.result);
      onDataLoad(data);
    };
    reader.readAsText(selectedFile);
  };

  return (
    <div>
      <input type="file" onChange={handleFileChange} />
    </div>
  );
}
