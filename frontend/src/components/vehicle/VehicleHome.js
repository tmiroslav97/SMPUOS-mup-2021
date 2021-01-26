import React from 'react';
import { Row, Col, Container} from 'react-bootstrap';
import { history } from '../../index';

const VehicleHome = () => {
    return (
        <Container>
            <Row>
                <Col md={{ span: 10, offset: 1 }} xs={12}>
                    <center><h1 className="mb-5">Saobraćajni registar početna</h1></center>
                </Col>
            </Row>
            
        </Container>
    );
}

export default VehicleHome;
