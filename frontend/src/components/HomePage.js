import React from 'react';
import { Row, Col, Container, Card, Button } from 'react-bootstrap';
import { history } from '../index';

const HomePage = () => {
    return (
        <Container>
            <Row>
                <Col md={{ span: 10, offset: 1 }} xs={12}>
                    <center><h1 className="mb-5">SMPUOS servisi - početna strana</h1></center>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col md={4} xs={12} >
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/central-reg.png" />
                        <Card.Body>
                            <Card.Title>Centralni registar</Card.Title>
                            <Card.Text>
                                Pristupite centralnom registru građana.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/cent-reg') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col md={4} xs={12}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/counter.jpg" />
                        <Card.Body>
                            <Card.Title>Šalterska služba</Card.Title>
                            <Card.Text>
                                Pristupite šalterskoj službi.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/counter') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col md={4} xs={12}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/vehicle.png" />
                        <Card.Body>
                            <Card.Title>Vozila</Card.Title>
                            <Card.Text>
                                Pristupite sabraćajnom registru.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/vehicle') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
            <Row className="mb-3">
                <Col md={{ span: 6, offset: 1 }} xs={12}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/police.jpg" />
                        <Card.Body>
                            <Card.Title>Policija</Card.Title>
                            <Card.Text>
                                Pristupite policijskim servisima.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/police') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
                <Col md={4} xs={12}>
                    <Card style={{ width: '18rem' }}>
                        <Card.Img variant="top" src="imgs/health.jpg" />
                        <Card.Body>
                            <Card.Title>Zdravstvo</Card.Title>
                            <Card.Text>
                                Pristupite zdravstvenim servisima.
                            </Card.Text>
                            <Button variant="link" onClick={() => { history.push('/health') }}>Otvori</Button>
                        </Card.Body>
                    </Card>
                </Col>
            </Row>
        </Container>
    );
}

export default HomePage;
