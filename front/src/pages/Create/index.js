import { GiSpiderMask } from 'react-icons/gi';
import { useState } from 'react';
import { toast } from 'react-toastify';

import ClientUsers from '../../services/user.js';

import Sidebar from '../../components/Sidebar';
import Title from '../../components/Title';

import './style.css';

export default function Create() {

    const [name, setName] = useState('');
    const [company, setCompany] = useState('');
    const [releasedYear, setReleasedYear] = useState('');
    const [price, setPrice] = useState('');
    const [imageUrl, setImageUrl] = useState('');

    async function handleSave(e) {
        e.preventDefault();

        const data = {
            name: name,
            company: company,
            releasedYear: releasedYear,
            price: price,
            imageUrl: imageUrl,
        }

        const update = await ClientUsers.createUser(data);
        if (update.status === 201) {
            toast.success('Jogo cadastrado com sucesso!');
        } else {
            toast.error('Ops algo deu errado!');
        }
    }

    return (
        <div>
            <Sidebar />

                <div className="content">
                    <Title name="Registrar novo jogo">
                        <GiSpiderMask size={30} />
                    </Title>

                <main className="container">
                    <form action="" onSubmit={handleSave}>
                        <div className="input-field">
                            <input required type="text" value={name} onChange={(e) => setName(e.target.value)}
                                   placeholder="Nome do jogo"/>
                                <div className="underline"></div>
                        </div>
                        <div className="input-field">
                            <input required type="text" value={company} onChange={(e) => setCompany(e.target.value)}
                                   placeholder="Empresa"/>
                            <div className="underline"></div>
                        </div>
                        <div className="input-field">
                            <input required type="number" value={releasedYear} onChange={(e) => setReleasedYear(e.target.value)}
                                placeholder="Ano de Laçamento"/>
                            <div className="underline"></div>
                        </div>
                        <div className="input-field">
                            <input required type="number" value={price} onChange={(e) => setPrice(e.target.value)}
                                   placeholder="Preço"/>
                            <div className="underline"></div>
                        </div>
                        <div className="input-field">
                            <input required type="text" value={imageUrl} onChange={(e) => setImageUrl(e.target.value)}
                                   placeholder="Link de uma imagem"/>
                            <div className="underline"></div>
                        </div>
                        <input type="submit" value="Salvar"/>
                    </form>
                </main>
            </div>
        </div>
    )
}