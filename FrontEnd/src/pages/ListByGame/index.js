import { GiVikingHelmet } from 'react-icons/gi';
import { useState } from 'react';
import { toast } from 'react-toastify';

import ClientUsers from '../../services/user.js';

import Sidebar from '../../components/Sidebar';
import Title from '../../components/Title';

import './style.css';

export default function ListByGame() {

    const [game, setGames] = useState([]);

    const [name, setName] = useState('');

    async function listByGame(e) {
        e.preventDefault();

        const data = {
            name: name,
        }

        const response = await ClientUsers.listByGame(data.name);

        if (response.status === 200) {
            setGames(response.data)
            toast.success('Jogo Encontrado!');
        } else {
            toast.error('Jogo não encontrado!');
        }
    }

    return (
        <div>
            <Sidebar />

            <div className="content">
                <Title name="Buscar Jogo">
                    <GiVikingHelmet size={30} />
                </Title>

                <div className="container">
                    <form onSubmit={listByGame}>
                        <div className="input-field">
                            <input required type="text" value={name} onChange={(e) => setName(e.target.value)}
                                   placeholder="Nome do jogo"/>
                            <div className="underline"></div>
                        </div>
                        <input required type="text" value={name} onChange={(e) => setName(e.target.value)} />


                        <div class="table-wrapper">
                            <table class="fl-table">
                                <thead>
                                    <tr>
                                        <th>Nome</th>
                                        <th>Empresa</th>
                                        <th>Ano de Lançamento</th>
                                        <th>Preço</th>
                                        <th>Link da imagem do Jogo</th>
                                    </tr>
                                </thead>

                                <tbody>
                                    {game &&
                                        <tr key={1}>
                                            <td>{game.name} </td>
                                            <td>{game.company} </td>
                                            <td>{game.releasedYear} </td>
                                            <td>{game.price} </td>
                                            <td> <img src={game.imageUrl} width={100} /> </td>
                                        </tr>
                                    }
                                </tbody>
                            </table>
                        </div>

                        <button type="submit">Buscar Jogo</button>

                    </form>
                </div>

            </div>
        </div>
    )
}