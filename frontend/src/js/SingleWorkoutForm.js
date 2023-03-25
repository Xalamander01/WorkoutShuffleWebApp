import React from 'react';
import ListWorkout from './ListWorkout';
import '../css/SingleWorkoutForm.css';

export default function SingleWorkoutForm() {

    const [workout, setWorkout] = React.useState(null)
    const [workoutType, setWorkoutType] = React.useState(null)
    const [submittedWorkoutType, setSubmittedWorkoutType] = React.useState(null)
    const workoutElement = ( <div>
                                <ListWorkout workout={workout} />
                                <button onClick={ReShuffle}>Another one</button>
                            </div> )

    React.useEffect(()=>{
                    if ( submittedWorkoutType != null  ) {
                        let fetchUrl = "/singleWorkout/"+submittedWorkoutType
                        fetch(fetchUrl).then(res=>res.json()).then(data=>setWorkout(data))
                    }
                },[submittedWorkoutType])

    function handleChange(event) {
        const {value} = event.target
        setWorkoutType(value)
    }

    function handleSubmit(event) {
        event.preventDefault()
        setSubmittedWorkoutType(workoutType)
    }

    function ReShuffle(event) {
        event.preventDefault()
        setSubmittedWorkoutType(null)
    }

    return (
        <div className="singleWorkoutForm">
            { submittedWorkoutType == null ? <div> <h3>Get a single workout</h3>
            <form onSubmit={handleSubmit} >
                <fieldset>
                    <legend>Today I would like to train</legend>
                    <input type="radio"
                        id="push"
                        name="workoutType"
                        value="push"
                        checked={workoutType === "push"}
                        onChange={handleChange} />
                    <label htmlFor="push">Push</label><br/>
                    <input type="radio"
                        id="pull"
                        name="workoutType"
                        value="pull"
                        checked={workoutType === "pull"}
                        onChange={handleChange} />
                    <label htmlFor="pull">Pull</label><br/>
                    <input type="radio"
                        id="upper"
                        name="workoutType"
                        value="upper"
                        checked={workoutType === "upper"}
                        onChange={handleChange} />
                    <label htmlFor="upper">Push and Pull</label><br/>
                    <input type="radio"
                        id="legs"
                        name="workoutType"
                        value="legs"
                        checked={workoutType === "legs"}
                        onChange={handleChange} />
                    <label htmlFor="legs">Legs</label><br/>
                    <input type="radio"
                        id="fullBody"
                        name="workoutType"
                        value="fullBody"
                        checked={workoutType === "fullBody"}
                        onChange={handleChange} />
                    <label htmlFor="fullBody">Full Body</label><br/>
                </fieldset>
                <button type="submit">Submit</button>
            </form> </div> : null }
            { submittedWorkoutType != null ? workoutElement : null }
        </div>
    );
}
