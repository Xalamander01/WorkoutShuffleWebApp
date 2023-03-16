import React from 'react';
import Navbar from './Navbar';
import SingleWorkoutForm from './SingleWorkoutForm';
import WeeklyWorkoutForm from './WeeklyWorkoutForm';
import Database from './Database';
import Search from './Search';
import About from './About';
import Login from './Login';

export default function App() {

    const [showWorkoutForm, setShowWorkoutForm] = React.useState(true)
    const [showSplitForm, setShowSplitForm] = React.useState(false)
    const [showDatabase, setShowDatabase] = React.useState(false)
    const [showSearch, setShowSearch] = React.useState(false)
    const [showAbout, setShowAbout] = React.useState(false)
    const [showLogin, setShowLogin] = React.useState(false)

    return (
        <div>
            <Navbar
                showWorkoutForm={showWorkoutForm}
                setShowWorkoutForm={setShowWorkoutForm}
                showSplitForm={showSplitForm}
                setShowSplitForm={setShowSplitForm}
                showDatabase={showDatabase}
                setShowDatabase={setShowDatabase}
                showSearch={showSearch}
                setShowSearch={setShowSearch}
                showAbout={showAbout}
                setShowAbout={setShowAbout}
                showLogin={showLogin}
                setShowLogin={setShowLogin}
            />
            {showWorkoutForm && <SingleWorkoutForm />}
            {showSplitForm && <WeeklyWorkoutForm />}
            {showDatabase && <Database />}
            {showSearch && <Search />}
            {showAbout && <About />}
            {showLogin && <Login />}
        </div>
    )
}
