select * from herramientas;
select * from pagos;
select * from reservas;
select * from alquiler;
select * from factura;
select * from usuarios;
select * from login;
select * from inventario;
select * from reporte;


insert into login values
(1, 1, 'aleja123', 'USER', 'aleja');

insert into pagos values
(4, '2025/02/10', 1, 50000, 'Finalizado', 'Transacción', 'Alejandra'),
(4, '2025/02/10', 2, 50000, 'Finalizado', 'Efectivo', 'Alejandra'),
(4, '2025/02/10', 3, 50000, 'Finalizado', 'Tarjeta', 'Alejandra'),
(4, '2025/02/10', 4, 50000, 'Finalizado', 'Transacción', 'Alejandra');


insert into herramientas values
(1, 1, 15000, 'ejemplo', 'buen estado', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQR5SfQdZVJJ0fNvITvf9qXHO_nW74BnXG-HA&s', 'Martillo');

insert into herramientas values
(2, 1, 45000, 'ejemplo', 'buen estado', 'https://alfagresalfa.vtexassets.com/arquivos/ids/333591-800-auto?v=638657799097500000&width=800&height=auto&aspect=true', 'Taladro');

insert into herramientas values
(3, 2, 45000, 'ejemplo', 'buen estado', 'https://www.dateriumsystem.com/appfiles/clientes/308/catalogo/SERRUCHO-COSTILLA-ALYCO-144088-PRINCIPAL.jpg', 'Serrucho');

insert into herramientas values
(4, 2, 40000, 'ejemplo', 'buen estado', 'https://www.herragro.com/shop/374-large_default/zapapico-3105-encabado.jpg', 'Pica');

insert into herramientas values
(5, 3, 50000, 'ejemplo', 'buen estado', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3nbYAX6J_zQodA6HZM3syTQDKvvutPglAsA&s', 'Sierra de calar');

insert into herramientas values
(6, 3, 40000, 'ejemplo', 'buen estado', 'https://cdnx.jumpseller.com/universaldetornillosyherr/image/62179986/resize/610/610?1743804076', 'Pistola de calor');

insert into herramientas values
(7, 4, 200000, 'ejemplo', 'buen estado', 'https://www.sdlgla.com/hubfs/Produtos%20Pt-Br/Resolu%C3%A7%C3%A3o%20%5BALTA%5D/E660FL/Escav_E660FL_3000x1920_Alta_06.jpg', 'Excavadora');

insert into herramientas values
(8, 4, 200000, 'ejemplo', 'buen estado', 'https://www.manitowoc.com/sites/default/files/media/divers/images/2021-07/Manitowoc-launches-class-leading-Grove-GHC110-telescoping-crawler-crane.jpg', 'Grúa');


--expiracion reserva
insert into reservas values
('true', '2025-05-20', '2025-05-18', 7000, 1, 1, 1, 'finalizada', 'Martillo', 'Alejandra');

insert into reservas values
('false', '2025-03-20', '2025-03-18', 23000, 3, 2, 1, 'finalizada', 'Serrucho', 'Alejandra');

insert into reservas values
('true', '2025-04-20', '2025-04-18', 23000, 4, 3, 1, 'finalizada', 'Pica', 'Alejandra');


insert into alquiler values
('2025-04-20', '2025-05-18', 1, 15000, 30000, 1, 'buen estado', 'Martillo', 'Alejandra');

insert into alquiler values
('2025-03-20', '2025-03-18', 2, 45000, 90000, 1, 'buen estado', 'Serrucho', 'Alejandra');

insert into alquiler values
('2025-04-20', '2025-04-18', 3, 40000, 8, 1, 'buen estado', 'Pica', 'Alejandra');

insert into factura values
('2025-05-25', 1, 25000, 'Transacción', 'Alejandra'),
('2024-03-12', 2, 50000,'Efectivo', 'Franco'),
('2022-05-15', 3, 100000,'Tarjeta', 'Zully');

insert into inventario values
(2, 'false', 1, 1),
(3, 'true', 3, 2),
(6, 'true', 4, 3);

insert into reporte values
(1, 1, 1, 4);