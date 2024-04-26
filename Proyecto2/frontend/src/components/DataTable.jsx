import {
  Table,
  TableHeader,
  TableColumn,
  TableBody,
  TableRow,
  TableCell,
} from "@nextui-org/react";

export default function DataTable({ data }) {
  return (
    <Table>
      <TableHeader>
        <TableColumn>Codigo</TableColumn>
        <TableColumn>Nombres</TableColumn>
        <TableColumn>Apellidos</TableColumn>
        <TableColumn>Correo</TableColumn>
      </TableHeader>
      <TableBody>
        {data?.map((user) => (
          <TableRow key={user?.codigo}>
            <TableCell>{user?.codigo}</TableCell>
            <TableCell>{user?.nombres}</TableCell>
            <TableCell>{user?.apellidos}</TableCell>
            <TableCell>{user?.correo}</TableCell>
          </TableRow>
        ))}
      </TableBody>
    </Table>
  );
}
