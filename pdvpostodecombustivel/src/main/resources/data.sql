INSERT INTO bomba (numero, status) VALUES (1, 'DISPONIVEL') ON CONFLICT (numero) DO NOTHING;
INSERT INTO bomba (numero, status) VALUES (2, 'DISPONIVEL') ON CONFLICT (numero) DO NOTHING;
INSERT INTO bomba (numero, status) VALUES (3, 'DISPONIVEL') ON CONFLICT (numero) DO NOTHING;
INSERT INTO bomba (numero, status) VALUES (4, 'DISPONIVEL') ON CONFLICT (numero) DO NOTHING;

INSERT INTO acesso (usuario, senha, tipo_acesso)
VALUES ('admin', '123', 'ADMINISTRADOR')
ON CONFLICT (usuario) DO NOTHING;