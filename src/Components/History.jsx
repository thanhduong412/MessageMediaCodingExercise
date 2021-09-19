import axios from 'axios';
import React, { useState } from 'react';
import HistoryTable from "./HistoryTable";

const History = () => {
    const [tableVisible, setTableVisible] = useState(false);
    const [msgHistory, setMsgHistory] = useState([]);

    const showHistory = () => {
        if(tableVisible === false){
            axios.get('http://localhost:8090/messages/history').then(response =>{
                setMsgHistory(response.data);
                setTableVisible(true);
            }).catch(error =>{
                alert(error);
            }) 
        }else{
            setTableVisible(false);
        }

    }

    return(
        <div>
            <button type="button" onClick={showHistory}>History</button>
            {tableVisible && <HistoryTable data={msgHistory}/>}
        </div>
    )
}

export default History;