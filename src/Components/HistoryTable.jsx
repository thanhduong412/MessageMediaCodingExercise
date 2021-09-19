import React from 'react';
import PropTypes from 'prop-types';

const HistoryTable = (props) =>{
   
    return(
        <div>
            <table>
                <thead>
                    <tr>
                        <th>Message ID</th>
                        <th>Destination Number</th>
                        <th>Content</th>
                        <th>Timestamp</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    {props.data && props.data.map((item, index) => (
                        <tr key={index}>
                            <td>{item.id}</td>
                            <td>{item.destinationNumber}</td>
                            <td>{item.content}</td>
                            <td>{item.timestamp}</td>
                            <td>{item.status}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

HistoryTable.propTypes = {
    data: PropTypes.array
}

export default HistoryTable;