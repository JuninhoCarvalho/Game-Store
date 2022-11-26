import { GiHydra } from 'react-icons/gi';
import { useState } from 'react';
import { toast } from 'react-toastify';

import ClientUsers from '../../services/user.js';

import Sidebar from '../../components/Sidebar';
import Title from '../../components/Title';

import './style.css';

export default function ListAll() {

    const [games, setGames] = useState([
    ]);

    async function ListAll(e) {
        e.preventDefault();

        const response = await ClientUsers.listAll();

        if (response.status === 200) {
            setGames(response.data)
            toast.success('Jogos Listados com sucesso!');
        } else {
            toast.error('Ops algo deu errado!');
        }
    }

    return (
        <div>
            <Sidebar />

            <div className="content">
                <Title name="Buscar todos os jogos">
                    <GiHydra size={30} />
                </Title>

                <div className="container">
                    <form onSubmit={ListAll}>
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
                                    {games && games.map((user, index) =>
                                        <tr key={index}>
                                            <td>{user.name} </td>
                                            <td>{user.company} </td>
                                            <td>{user.releasedYear} </td>
                                            <td>{user.price} </td>
                                            <td>{user.imageUrl} </td>
                                        </tr>
                                    )}
                                </tbody>
                            </table>
                        </div>

                        <button type="submit">Buscar Todos</button>

                    </form>
                </div>

            </div>
        </div>
    )
}