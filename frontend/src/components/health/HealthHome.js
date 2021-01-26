import React from 'react';
import { Row, Col, Container, Card, Button } from 'react-bootstrap';
import { history } from '../../index';

const HealthHome = () => {
    return (
        <Container>
            <Row>
                <Col md={{ span: 10, offset: 1 }} xs={12}>
                    <center><h1 className="mb-5">Zdravstveni servisi početna</h1></center>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col md={{ span: 4, offset: 2 }} xs={12} >
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/nurse.jpg" />
                        <Card.Body>
                            <Card.Title>Medicinsko osoblje</Card.Title>
                            <Card.Text>
                                Pristupite funkcionalnostima medicinskog osoblja.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/health/nurse') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col md={{ span: 4, offset: 2 }} xs={12}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/doctor.jpg" />
                        <Card.Body>
                            <Card.Title>Doktori</Card.Title>
                            <Card.Text>
                                Pristupite funcionalnostima doktora.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/health/doctor') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
}

export default HealthHome;
