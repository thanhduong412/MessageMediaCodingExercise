import axios from 'axios';
import React from 'react';
import { Formik, Field, Form} from 'formik';

const MessageForm = () => {
    const handleSubmit = (e) => {
        e.timestamp = new Date().toISOString().slice(0, 19).replace('T', ' ');
        
        axios.post('http://localhost:8090/messages/send', e).then(response =>{
            alert(response.request.response);
        }).catch(error =>{
            alert(error);
        });
    }

    return(
        <Formik initialValues={{destinationNumber: 0, content: '', timestamp: '', status: 'Failure'}}
            onSubmit = {handleSubmit}
        >
        <Form>
            <label htmlFor="destinationNumber">Destination Number: </label>
            <Field id="destinationNumber" name="destinationNumber" placeholder = "0123456789" type="tel"/>

            <label htmlFor="content">Content: </label>
            <Field id="content" name="content" placeholder= "Type your message here!" type="text"/>
            <button type="submit">Submit</button>
        </Form>
        </Formik>
    )   
}

export default MessageForm;