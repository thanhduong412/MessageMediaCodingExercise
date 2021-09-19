import React from 'react';
import { Formik, Field, Form} from 'formik';

export const MessageForm = () => (
    <>
        <Formik initialValues={{
            destinationNumber: 0,
            message: '',
            timestamp: '',
            isFail: true,
        }}

        onSubmit={async (values) => {
            values.timestamp = new Date().toISOString().slice(0, 19).replace('T', ' ');
            console.log(values);

            await new Promise((r) => setTimeout(r, 500));
            values.isFail ? alert("Message Status: Failure") : alert("Message Status: Success");
          }}
        >
            <Form>
                <label htmlFor="destinationNumber">Destination Number: </label>
                <Field id="destinationNumber" name="destinationNumber" placeholder = "0123456789" type="tel"/>

                <label htmlFor="message">Message: </label>
                <Field id="message" name="message" placeholder= "Type your message here!" type="text"/>

                <button type="submit">Submit</button>
            </Form>
        </Formik>
    </>
)