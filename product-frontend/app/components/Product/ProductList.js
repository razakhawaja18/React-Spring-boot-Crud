import React from 'react';
import { Table, Button } from 'react-bootstrap';

class ProductList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      error: null,
      products: []
    }
  }

  componentDidMount() {
    const apiUrl = 'http://localhost:8282/api/v1/consumer/producto';

    fetch(apiUrl)
      .then(res => res.json())
      .then(
        (result) => { 
          this.setState({
            products: result.productoDtoList
          });
        },
        (error) => {
          this.setState({ error });
        }
      )
  }

  render() {
    const { error, products} = this.state;

    if(error) {
      return (
        <div>Error: {error.message}</div>
      )
    } else {
      return(
        <div>
          <h2>Product List</h2>
          <Table>
            <thead>
              <tr>
                <th>#ProductoID</th>
                <th>Producto Nombre</th>
                <th>Producto Descripcion</th>
                <th>Producto Cantidad</th>
                <th>Producto Ubicacion</th>
                <th>creadoEn</th>
                <th>actualizadoALas</th>
              </tr>
            </thead>
            <tbody>
              {products.map(product => (
                <tr key={product.productoId}>
                  <td>{product.productoId}</td>
                  <td>{product.productoNombre}</td>
                  <td>{product.productoDescripcion}</td>
                  <td>{product.productoCantidad}</td>
                  <td>{product.productoUbicacion}</td>
                  <td>{product.creadoEn}</td>
                  <td>{product.actualizadoALas}</td>
                  <td><Button style={{width: '100px'}} variant="info" onClick={() => this.props.editProduct(product.productoId)}>Edit</Button></td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
      )
    }
  }
}

export default ProductList;