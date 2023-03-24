import React from 'react';
import Header from './Header';
import SingleWorkoutForm from './SingleWorkoutForm';
import WeeklyWorkoutForm from './WeeklyWorkoutForm';
import Database from './Database';
import Search from './Search';
import About from './About';
import Login from './Login';

export default function App() {

    const [showWorkoutForm, setShowWorkoutForm] = React.useState(false)
    const [showSplitForm, setShowSplitForm] = React.useState(true)
    const [showDatabase, setShowDatabase] = React.useState(false)
    const [showSearch, setShowSearch] = React.useState(false)
    const [showAbout, setShowAbout] = React.useState(false)
    const [showLogin, setShowLogin] = React.useState(false)

    return (
        <div>
            <Header
                setShowWorkoutForm={setShowWorkoutForm}
                setShowSplitForm={setShowSplitForm}
                setShowDatabase={setShowDatabase}
                setShowSearch={setShowSearch}
                setShowAbout={setShowAbout}
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
