import React from "react";
import { Routes, Route } from "react-router-dom";

import Create from '../pages/Create';
import Delete from '../pages/Delete';
import List from '../pages/ListAll';
import ListByGame from '../pages/ListByGame';

export default function Routers() {
    return (
        <Routes>
            <Route exact path="/" element={<Create />} />
            <Route exact path="/Comprar" element={<Delete />} />
            <Route exact path="/list" element={<List />} />
            <Route exact path="/listByGame" element={<ListByGame />} />
        </Routes>
    )
}