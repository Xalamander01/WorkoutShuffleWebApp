import React from 'react';
import Navbar from './Navbar';
import Title from './Title';
import '../css/Header.css';

export default function Header(props) {
    return (
        <div className="header">
            <Title />
            <Navbar
                setShowWorkoutForm={props.setShowWorkoutForm}
                setShowSplitForm={props.setShowSplitForm}
                setShowDatabase={props.setShowDatabase}
                setShowSearch={props.setShowSearch}
                setShowAbout={props.setShowAbout}
                setShowLogin={props.setShowLogin}
            />
        </div>
    )
}