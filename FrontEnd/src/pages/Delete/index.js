import { GiTwoCoins } from 'react-icons/gi';
import { useState } from 'react';
import { toast } from 'react-toastify';

import ClientUsers from '../../services/user.js';

import Sidebar from '../../components/Sidebar';
import Title from '../../components/Title';

import './style.css';

export default function Delete() {

    const [name, setName] = useState('');

    async function handleDelete(e) {
        e.preventDefault();

        const data = {
            name: name,
        }

        const update = await ClientUsers.deleteUser(data.name);
        console.log('update', update);
        if (update.status === 204) {
            toast.success('Jogo comprado com sucesso!');
        } else {
            toast.error('Ops algo deu errado!');
        }
    }

    return (
        <div>
            <Sidebar />

            <div className="content">
                <Title name="Comprar Jogo">
                    <GiTwoCoins size={30} />
                </Title>

                <main className="container">
                    <form action="" onSubmit={handleDelete}>
                        <div className="input-field">
                            <input required type="text" value={name} onChange={(e) => setName(e.target.value)}
                                   placeholder="Nome do jogo"/>
                            <div className="underline"></div>
                        </div>
                        <input type="submit" value="Comprar"/>
                    </form>
                </main>
            </div>
        </div>
    )
}