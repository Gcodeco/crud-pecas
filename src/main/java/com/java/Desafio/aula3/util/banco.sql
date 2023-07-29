use aula;

create  table pecas
(
    id int primary key auto_increment,
    parte_number integer,
    nome_da_peca varchar(50) not null,
    descricao varchar(30) not null,
    ativo int not null
);


 insert into pecas (parte_number, nome_da_peca, descricao,  ativo ) values ( 1,"Parafuso", "Parafuso de Rosca", 1);
 insert into pecas (parte_number, nome_da_peca, descricao,  ativo ) values ( 2,"Porca", "Tamanho 7", 2 );
 insert into pecas (parte_number, nome_da_peca, descricao,  ativo ) values ( 3,"Macaco", "Macaco Hidraulico", 1 );
 insert into pecas (parte_number, nome_da_peca, descricao,  ativo ) values ( 4,"BombaD'gua", "Bomba Bosh", 1 );
 insert into pecas (parte_number, nome_da_peca, descricao,  ativo ) values ( 5,"Motor", "Motor VW 5.6", 2);
 insert into pecas (parte_number, nome_da_peca, descricao,  ativo ) values ( 6,"Parafuso", "Parafuso sem Rosca", 1 );

select * from pecas;
