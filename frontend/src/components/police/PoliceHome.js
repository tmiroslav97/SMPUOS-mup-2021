import React from 'react';
import { Row, Col, Container} from 'react-bootstrap';
import { history } from '../../index';

class PoliceHome extends React.Component {
    constructor(props) {
        super(props);
        this.data = '';
        this.state = {firstName: '', lastName:'', UID:'', fatherName:'',email:'', type:'', brand:'', regNum:''};
    
        this.handleChangeFName = this.handleChangeFName.bind(this);
        this.handleChangeLName = this.handleChangeLName.bind(this);
        this.handleChangeUID = this.handleChangeUID.bind(this);
        this.handleChangeFatName = this.handleChangeFatName.bind(this);
        this.handleChangeEmail = this.handleChangeEmail.bind(this);

        this.handleChangeType = this.handleChangeType.bind(this);
        this.handleChangeBrand = this.handleChangeBrand.bind(this);
        this.handleChangeRegNum = this.handleChangeRegNum.bind(this);

        this.handleSubmit = this.handleSubmit.bind(this);
      }


      handleChangeFName(event) {
        this.setState({firstName: event.target.value});
      }

      handleChangeLName(event) {
        this.setState({lastName: event.target.value});
      }

      handleChangeUID(event) {
        this.setState({UID: event.target.value});
      }

      handleChangeFatName(event) {
        this.setState({fatherName: event.target.value});
      }

      handleChangeType(event) {
        this.setState({type: event.target.value});
      }

      handleChangeBrand(event) {
        this.setState({brand: event.target.value});
      }

      handleChangeRegNum(event) {
        this.setState({regNum: event.target.value});
      }

      handleChangeEmail(event){
        this.setState({email: event.target.value});
      }

      handleSubmit(event) {
        alert('A name was submitted: ' + this.state.firstName + this.state.lastName);
        event.preventDefault();

        alert(JSON.stringify(this.state));

        var data1 = new FormData();
        let data = {
            FirstName : this.state.firstName,   
            LastName : this.state.lastName,
            UID : this.state.UID, 
            FatherName : this.state.fatherName,
            Type : this.state.type, 
            Brand : this.state.brand,
            RegNum : this.state.regNum, 
            Email: this.state.email
        }
        data1.append("json",JSON.stringify(data));

        fetch('https://localhost:44323/api/Police/SendRequest', {
        method: 'POST', // or 'PUT'
        mode: 'no-cors',
      headers: {
        'Accept': "application/json, text/plain, */*",
      //          'Content-Type': "application/json;charset=utf-8"
      },
        body: data1, 
      })
      .then(response => response.json())
      .then(data => {
        console.log('Success:', this.data);
        alert(data);
      })
      .catch((error) => {
        console.error('Error:', error);
        alert("Nije uspesno izvrseno dodeljivanje dozvole");
        // alert(error);
      });
      }

      render(){
        return (
            <Container>
                <Row>
                    <Col md={{ span: 10, offset: 1 }} xs={12}>
                        <center><h1 class="text-danger" >Izdavanje dozvole za posedovanje oružja</h1></center>
                    </Col>
                </Row>
    
                <br/>
                <form onSubmit={this.handleSubmit}>
        <h4 class="text-danger">Podaci iz lične karte</h4>
   
        <div class="p-3 mb-2 bg-success text-white">
        <div class="form-group">
            <label>Ime</label>
            <input class="form-control" type="text" value={this.state.firstName} onChange={this.handleChangeFName} />
        </div>
        <div class="form-group">
            <label>Prezime</label>
            <input class="form-control" type="text" value={this.state.lastName} onChange={this.handleChangeLName} />
        </div>
        <div class="form-group">   
            <label> JMBG</label>
            <input class="form-control" type="text" value={this.state.UID} onChange={this.handleChangeUID} />
        </div>  
        <div class="form-group">   
            <label> Ime oca</label>
            <input class="form-control" type="text" value={this.state.fatherName} onChange={this.handleChangeFatName} />
        </div>   
        <div class="form-group">   
            <label> Email</label>
            <input class="form-control" type="text" value={this.state.email} onChange={this.handleChangeEmail} />
        </div>
        </div>
        <br />
        
        <h4 class="text-danger">Podaci iz oružanog lista</h4>
    <div class="p-3 mb-2 bg-success text-white">
        <div class="form-group">   
            <label> Vrsta</label>
            <input class="form-control"  type="text" value={this.state.type} onChange={this.handleChangeType} />
        </div> 
    
        <div class="form-group">   
            <label> Marka</label>
            <input class="form-control"  type="text" value={this.state.brand} onChange={this.handleChangeBrand}/>
        </div>  
    
         <div class="form-group">   
            <label> Fabricki broj</label>
            <input class="form-control"  type="text" value={this.state.regNum} onChange={this.handleChangeRegNum}/>
        </div> 

      </div>
        <br />
     
        <button class="btn btn-danger">POTVRDI</button> 
       
    </form>
            </Container>
        );
    }
    
}

export default PoliceHome;