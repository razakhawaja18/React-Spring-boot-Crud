import React, { Component } from 'react';
// import './App.css';
import { Container, Button, Alert } from 'react-bootstrap';
import ProductList from 'components/Product/ProductList';
import AddProduct from 'components/Product/AddProduct';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.min.js';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isAddProduct: false,
      error: null,
      response: {},
      product: {},
      isEditProduct: false
    }
    this.onFormSubmit = this.onFormSubmit.bind(this);
  }

  onCreate() {
    this.setState({ isAddProduct: true,  isEditProduct: false, product: {}});
  }

  onFormSubmit(data) {
    let apiUrl;

    if(this.state.isEditProduct){
      apiUrl = 'http://localhost:8282/api/v1/consumer/producto';
    } else {
      apiUrl = 'http://localhost:8282/api/v1/consumer/producto';
    }

    const myHeaders = new Headers();
    myHeaders.append('Content-Type', 'application/json');
    myHeaders.append('accept', 'application/json');

    const options = {
      method: 'POST',
      body: JSON.stringify(data),
      headers: { 'Content-Type': 'application/json' }
    };

    fetch(apiUrl, options)
      .then(res => res.json())
      .then(result => {
        this.setState({
          response: result.responseMessage,
          isAddProduct: false,
          isEditProduct: false
        })
      },
      (error) => {
        this.setState({ error });
      }
    )
  }

  editProduct = productId => {
    const apiUrl = 'http://localhost:8282/api/v1/consumer/producto/'+productId;
    const formData = new FormData();
    const options = {
      method: 'Get',
    }

    fetch(apiUrl, options)
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            product: result.productoDto,
            isEditProduct: true,
            isAddProduct: true
          });
        },
        (error) => {
          this.setState({ error });
        }
      )
  }

  render() {

    let productForm;
    if(this.state.isAddProduct || this.state.isEditProduct) {
      productForm = <AddProduct onFormSubmit={this.onFormSubmit} product={this.state.product} />
    }

    return (
      <div className="App">
        <Container>
          <h1 style={{textAlign:'center'}}>Producto Application</h1>
          {!this.state.isAddProduct && <Button variant="primary" onClick={() => this.onCreate()}>Add Product</Button>}
          {this.state.response.message === 'success' && <div><br /><Alert variant="info">{this.state.response.message}</Alert></div>}
          {!this.state.isAddProduct && <ProductList editProduct={this.editProduct}/>}
          { productForm }
          {this.state.error && <div>Error: {this.state.error.message}</div>}
        </Container>
      </div>
    );
  }
}

export default App;