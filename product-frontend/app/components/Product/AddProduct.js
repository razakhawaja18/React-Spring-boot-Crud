import React from 'react';
import { Row, Form, Col, Button } from 'react-bootstrap';

class AddProduct extends React.Component {
  constructor(props) {
    super(props);
    this.initialState = {
      productoId: '',
      productoNombre: '',
      productoDescripcion: '',
      productoCantidad: '',
      productoUbicacion: ''
    }

    if(props.product){
      this.state = props.product
    } else {
      this.state = this.initialState;
    }

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    const name = event.target.name;
    const value = event.target.value;

    this.setState({
      [name]: value
    })
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.onFormSubmit(this.state);
    this.setState(this.initialState);
  }

  render() {

    let pageTitle;
    if(this.state.id) {
      pageTitle = <h2>Edit Producto</h2>
    } else {
      pageTitle = <h2>Add Producto</h2>
    }

    return(
      <div>
        {pageTitle}
        <Row>
          <Col sm={6}>
            <Form onSubmit={this.handleSubmit}>
              <Form.Group controlId="productoNombre">
                <Form.Label>Producto Nombre</Form.Label>
                <Form.Control
                  type="text"
                  name="productoNombre"
                  value={this.state.productoNombre}
                  onChange={this.handleChange}
                  placeholder="Producto Nombre"/>
              </Form.Group>
              <Form.Group controlId="productoDescripcion">
                <Form.Label>Producto Descripcion</Form.Label>
                <Form.Control
                  type="text"
                  name="productoDescripcion"
                  value={this.state.productoDescripcion}
                  onChange={this.handleChange}
                  placeholder="Producto Descripcion" />
              </Form.Group>
              <Form.Group controlId="productoCantidad">
                <Form.Label>Producto Cantidad</Form.Label>
                <Form.Control
                  type="number"
                  name="productoCantidad"
                  value={this.state.productoCantidad}
                  onChange={this.handleChange}
                  placeholder="Producto Cantidad" />
              </Form.Group>
              <Form.Group controlId="productoUbicacion">
                <Form.Label>Producto Ubicacion</Form.Label>
                <Form.Control
                  type="text"
                  name="productoUbicacion"
                  value={this.state.productoUbicacion}
                  onChange={this.handleChange}
                  placeholder="Producto Ubicacion" />
              </Form.Group>
              <Form.Group>
                <Form.Control type="hidden" name="productoId" value={this.state.productoId} />
                <Button variant="success" type="submit">Save</Button>
              </Form.Group>
            </Form>
          </Col>
        </Row>
      </div>
    )
  }
}

export default AddProduct;