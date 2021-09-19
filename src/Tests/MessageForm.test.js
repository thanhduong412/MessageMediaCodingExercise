import React from 'react'
import {render, screen, waitFor} from '@testing-library/react'
import userEvent from '@testing-library/user-event'

import MessageForm from "../Components/MessageForm";

window.alert = jest.fn();

test('Render and Submit Form', async () => {
  const handleSubmit = jest.fn();
  render(<MessageForm />);

  userEvent.type(screen.getByLabelText(/destination number:/i, 123));
  userEvent.type(screen.getByLabelText(/content:/i, 'Foo'));

  userEvent.click(screen.getByRole('button', {name: /submit/i}));

  await waitFor(() =>
    expect(handleSubmit).toHaveBeenCalledWith({
        destinationNumber: 123,
        content: 'Foo',
        timestamp: '',
        status: 'Failure',
    }),
  )
})