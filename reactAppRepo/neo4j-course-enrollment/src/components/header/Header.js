import React from 'react'
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faGraduationCap} from '@fortawesome/free-solid-svg-icons'
import Button from 'react-bootstrap/Button'
import Container from 'react-bootstrap/Container'
import Nav from 'react-bootstrap/Nav'
import NavBar from 'react-bootstrap/Navbar'
import {useNavigate, NavLink} from 'react-router-dom'

const Header = () => {
    return (
        <NavBar>
            <Container fluid>
                <NavBar.Brand href="/" className='menu-link' style={{"color":"white"}}>
                    <FontAwesomeIcon icon={faGraduationCap} />Course Enrollment</NavBar.Brand>
                <NavBar.Toggle aria-controls="basic-navbar-nav" />
                <Nav 
                    className='me-auto my-2 my-lg-0'
                    style={{"maxHeight":"100px"}}
                    navbarScroll>
                </Nav>
                <Button variant='info' className='me-2'>Login</Button>
                <Button variant='info' className='me-2'>Register</Button>
            </Container>
        </NavBar>
    )
}

export default Header