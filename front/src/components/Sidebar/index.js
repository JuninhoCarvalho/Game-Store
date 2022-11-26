import { Link } from 'react-router-dom';
import { GiTriangleTarget, GiSquare, GiCircle} from "react-icons/gi";
import { TfiClose } from "react-icons/tfi";

import avatar from '../../assets/perfil.png';
import './style.css';

export default function Sidebar() {
    return (
        <div className="sidebar">
            <div>
                <img src={avatar} alt="Foto de perfil do usuário" />
            </div>
            <Link to="/">
                <GiTriangleTarget color="white" size={24} />
                Criar
            </Link>
            <Link to="/List">
                <GiSquare color="white" size={24} />
                Buscar Todos
            </Link>
            <Link to="/ListByGame">
                <GiCircle color="white" size={24} />
                Buscar Jogo
            </Link>
            <Link to="/Comprar">
                <TfiClose color="white" size={24} />
                Comprar
            </Link>
        </div>
    )
}