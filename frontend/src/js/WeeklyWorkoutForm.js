import React from 'react';
import ListManyWorkouts from './ListManyWorkouts';
import '../css/WeeklyWorkoutForm.css';

export default function WeeklyWorkoutForm() {

    const [weeklyWorkouts, setWeeklyWorkouts] = React.useState(null)
    const [weeklyPreferences, setWeeklyPreferences] = React.useState({
        workoutsPerWeek:"2",
        repetitionTolerance:"5"
    })
    const [submittedWeeklyPreferences, setSubmittedWeeklyPreferences] = React.useState(null)

    const weeklyWorkoutsElement = (
        <div>
            <ListManyWorkouts workouts={weeklyWorkouts} ReShuffle={setSubmittedWeeklyPreferences} />
            <button onClick={ReShuffle}>Retry</button>
        </div>
    )

    React.useEffect(()=>{
                    if ( submittedWeeklyPreferences != null ) {
                        let fetchUrl = "/weeklyWorkouts/"+submittedWeeklyPreferences.workoutsPerWeek+"/"+submittedWeeklyPreferences.repetitionTolerance
                        fetch(fetchUrl).then(res=>res.json()).then(data=>setWeeklyWorkouts(data))
                    }
                },[submittedWeeklyPreferences])

    function handleChange(event) {
        const {name,value} = event.target
        setWeeklyPreferences(prevWeeklyPreferences=> {
            return {
                ...prevWeeklyPreferences,
                [name]:value
            }
        })
    }

    function handleSubmit(event) {
        event.preventDefault()
        setSubmittedWeeklyPreferences(weeklyPreferences)
    }

    function ReShuffle(event) {
        event.preventDefault()
        setSubmittedWeeklyPreferences(null)
    }

    return (
        <div key="WeeklyWorkoutForm" className="weeklyWorkoutForm">
            { ( submittedWeeklyPreferences == null || weeklyWorkouts == null ) ? <div> <h3>Get a weekly split</h3>
            <form onSubmit={handleSubmit}>
                <label htmlFor="workoutsPerWeek">I would like to train </label>
                <select name="workoutsPerWeek" id="workoutsPerWeek" value={weeklyPreferences.workoutsPerWeek} onChange={handleChange}>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select>
                times per week.<br/>
                I would like to do something extremely different every single time I am in the gym:<br/>
                <input type="radio" id="5"
                    name="repetitionTolerance"
                    value="5"
                    onChange={handleChange}
                    checked={weeklyPreferences.repetitionTolerance === "5"}/>
                <label htmlFor="5">Strongly disagree</label>
                <input type="radio" id="4"
                    name="repetitionTolerance"
                    value="4"
                    onChange={handleChange}
                    checked={weeklyPreferences.repetitionTolerance === "4"}/>
                <label htmlFor="4">Disagree</label>
                <input type="radio" id="3"
                    name="repetitionTolerance"
                    value="3"
                    onChange={handleChange}
                    checked={weeklyPreferences.repetitionTolerance === "3"}/>
                <label htmlFor="3">Neutral</label>
                <input type="radio" id="2"
                    name="repetitionTolerance"
                    value="2"
                    onChange={handleChange}
                    checked={weeklyPreferences.repetitionTolerance === "2"}/>
                <label htmlFor="2">Agree</label>
                <input type="radio" id="1"
                    name="repetitionTolerance"
                    value="1"
                    onChange={handleChange}
                    checked={weeklyPreferences.repetitionTolerance === "1"}/>
                <label htmlFor="1">Strongly agree</label><br/>
                <button type="submit">Submit</button>
            </form> </div> : null }
            { ( submittedWeeklyPreferences != null && weeklyWorkouts != null ) ? weeklyWorkoutsElement : null }
        </div>
    )
}