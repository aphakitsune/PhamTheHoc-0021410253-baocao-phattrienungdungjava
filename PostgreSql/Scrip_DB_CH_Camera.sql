--
-- PostgreSQL database dump
--

-- Dumped from database version 16.4
-- Dumped by pg_dump version 16.4

-- Started on 2024-10-20 19:25:18

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 230 (class 1259 OID 16751)
-- Name: ctdonhang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ctdonhang (
    id_ctdh integer NOT NULL,
    id_dh integer,
    id_sp integer,
    soluongmua_ctdh integer NOT NULL,
    giatrithuc_ctdh numeric(10,2) NOT NULL,
    giadagiam_ctdh numeric(10,2) NOT NULL,
    tiengiaohang_ctdh numeric(10,2) NOT NULL,
    thanhtien_ctdh numeric(10,2) NOT NULL
);


ALTER TABLE public.ctdonhang OWNER TO postgres;

--
-- TOC entry 229 (class 1259 OID 16750)
-- Name: ctdonhang_id_ctdh_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.ctdonhang ALTER COLUMN id_ctdh ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.ctdonhang_id_ctdh_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 228 (class 1259 OID 16728)
-- Name: donhang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.donhang (
    id_dh integer NOT NULL,
    id_kh integer,
    id_sp integer,
    id_nv integer,
    ngaydathang_dh date NOT NULL,
    tongtien_dh numeric(10,2),
    trangthai_dh character varying(50) NOT NULL,
    diachinguoinhan_dh character varying(50) NOT NULL,
    ngaygiao_dh date NOT NULL,
    ghichu_dh character varying(500) NOT NULL,
    luuychonguoiban_dh character varying(500) NOT NULL
);


ALTER TABLE public.donhang OWNER TO postgres;

--
-- TOC entry 227 (class 1259 OID 16727)
-- Name: donhang_id_dh_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.donhang ALTER COLUMN id_dh ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.donhang_id_dh_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 16690)
-- Name: khachhang; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.khachhang (
    id_kh integer NOT NULL,
    id_tk integer,
    anhdaidien_kh character varying(255),
    hovaten_kh character varying(255) NOT NULL,
    sdt_kh character varying(255) NOT NULL,
    dc_kh character varying(255) NOT NULL,
    email_kh character varying(255) NOT NULL
);


ALTER TABLE public.khachhang OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 16689)
-- Name: khachhang_id_kh_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.khachhang ALTER COLUMN id_kh ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.khachhang_id_kh_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 16703)
-- Name: nhacungcap; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nhacungcap (
    id_ncc integer NOT NULL,
    ten_ncc character varying(255) NOT NULL,
    loaisp character varying(255) NOT NULL,
    diachi_ncc character varying(255) NOT NULL,
    email_ncc character varying(255) NOT NULL,
    sdt_ncc character varying(255) NOT NULL
);


ALTER TABLE public.nhacungcap OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 16702)
-- Name: nhacungcap_id_ncc_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.nhacungcap ALTER COLUMN id_ncc ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.nhacungcap_id_ncc_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 226 (class 1259 OID 16722)
-- Name: nhanvien; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.nhanvien (
    id_nv integer NOT NULL,
    ten_nv character varying(255) NOT NULL,
    vaitro_nv character varying(255) NOT NULL,
    diachi_nv character varying(255) NOT NULL,
    email_nv character varying(255) NOT NULL,
    sdt_nv character varying(255) NOT NULL,
    ngaytuyendung_nv character varying(255) NOT NULL
);


ALTER TABLE public.nhanvien OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 16721)
-- Name: nhanvien_id_nv_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.nhanvien ALTER COLUMN id_nv ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.nhanvien_id_nv_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 16671)
-- Name: quyen; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.quyen (
    id_q integer NOT NULL,
    phanquyen character varying(10) NOT NULL,
    ghichu character varying(500),
    trangthai character varying(10) NOT NULL
);


ALTER TABLE public.quyen OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16670)
-- Name: quyen_id_q_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.quyen ALTER COLUMN id_q ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.quyen_id_q_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 224 (class 1259 OID 16709)
-- Name: sanpham; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.sanpham (
    id_sp integer NOT NULL,
    hinhanh character varying(255) NOT NULL,
    ten_sp character varying(255) NOT NULL,
    mausac_sp character varying(255) NOT NULL,
    loai_sp character varying(255) NOT NULL,
    id_ncc integer,
    soluong_sp integer NOT NULL,
    giamd_sp double precision NOT NULL,
    giakm_sp double precision NOT NULL,
    hoantra_sp character varying(255) NOT NULL,
    dvvanchuyen_sp character varying(255) NOT NULL,
    danhgia_sp character varying(500),
    mota_sp character varying(500)
);


ALTER TABLE public.sanpham OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 16708)
-- Name: sanpham_id_sp_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.sanpham ALTER COLUMN id_sp ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.sanpham_id_sp_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 16679)
-- Name: taikhoan; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.taikhoan (
    id_tk integer NOT NULL,
    id_q integer,
    taikhoan_tk character varying(50) NOT NULL,
    matkhau_tk character varying(50) NOT NULL,
    ngaydk_tk date NOT NULL
);


ALTER TABLE public.taikhoan OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16678)
-- Name: taikhoan_id_tk_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.taikhoan ALTER COLUMN id_tk ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.taikhoan_id_tk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 4903 (class 0 OID 16751)
-- Dependencies: 230
-- Data for Name: ctdonhang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ctdonhang (id_ctdh, id_dh, id_sp, soluongmua_ctdh, giatrithuc_ctdh, giadagiam_ctdh, tiengiaohang_ctdh, thanhtien_ctdh) FROM stdin;
1	1	1	1	4500000.00	4500000.00	0.00	4500000.00
2	2	2	1	1800000.00	1800000.00	0.00	1800000.00
3	3	3	2	2800000.00	2600000.00	200000.00	2800000.00
4	4	4	1	2300000.00	2300000.00	0.00	2300000.00
5	5	5	1	950000.00	950000.00	0.00	950000.00
\.


--
-- TOC entry 4901 (class 0 OID 16728)
-- Dependencies: 228
-- Data for Name: donhang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.donhang (id_dh, id_kh, id_sp, id_nv, ngaydathang_dh, tongtien_dh, trangthai_dh, diachinguoinhan_dh, ngaygiao_dh, ghichu_dh, luuychonguoiban_dh) FROM stdin;
1	1	1	1	2023-10-01	4500000.00	Đang giao	Hà Nội	2023-10-05	Ghi chú về đơn hàng 1	Lưu ý cho người bán 1
2	2	2	2	2023-10-02	1800000.00	Đã giao	PT Cao Lãnh	2023-10-06	Ghi chú về đơn hàng 2	Lưu ý cho người bán 2
3	3	3	3	2023-10-03	1400000.00	Đang giao	Đà Nẵng	2023-10-07	Ghi chú về đơn hàng 3	Lưu ý cho người bán 3
4	4	4	4	2023-10-04	2300000.00	Đang chờ	Hải Phòng	2023-10-08	Ghi chú về đơn hàng 4	Lưu ý cho người bán 4
5	5	5	5	2023-10-05	950000.00	Đã giao	Cần Thơ	2023-10-09	Ghi chú về đơn hàng 5	Lưu ý cho người bán 5
\.


--
-- TOC entry 4893 (class 0 OID 16690)
-- Dependencies: 220
-- Data for Name: khachhang; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.khachhang (id_kh, id_tk, anhdaidien_kh, hovaten_kh, sdt_kh, dc_kh, email_kh) FROM stdin;
1	1	link_to_image1.jpg	Nguyễn Văn A	123456789	Hà Nội	a@example.com
2	2	link_to_image2.jpg	Lê Thị A	987654321	PT Cao Lãnh	b@example.com
3	3	link_to_image3.jpg	Huỳnh Văn A	555666777	Đà Nẵng	c@example.com
4	4	link_to_image4.jpg	Nguyễn Văn Boom hàng	444333222	Hải Phòng	d@example.com
5	5	link_to_image5.jpg	Phan Thị Tester	888999000	Cần Thơ	e@example.com
6	1	exampleexamplelink_to_image1.jpg	exampleexampleNguyễn Văn A	example123456789	exampleHà Nội 	a@example.com
\.


--
-- TOC entry 4895 (class 0 OID 16703)
-- Dependencies: 222
-- Data for Name: nhacungcap; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nhacungcap (id_ncc, ten_ncc, loaisp, diachi_ncc, email_ncc, sdt_ncc) FROM stdin;
1	NCC 1	Camera	Hà Nội	ncc1@example.com	111222333
2	NCC 2	Lens	Lạng Sơn	ncc2@example.com	444555666
3	NCC 3	Tripod	Đà Nẵng	ncc3@example.com	777888999
4	NCC 4	Lighting	Hải Phòng	ncc4@example.com	999000111
5	NCC 5	Microphone	Cần Thơ	ncc5@example.com	222333444
\.


--
-- TOC entry 4899 (class 0 OID 16722)
-- Dependencies: 226
-- Data for Name: nhanvien; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.nhanvien (id_nv, ten_nv, vaitro_nv, diachi_nv, email_nv, sdt_nv, ngaytuyendung_nv) FROM stdin;
1	Nguyễn Văn X	Quản lý	Hà Nội	x@example.com	0123456789	2022-01-01
2	Trần Thị Y	Nhân viên bán hàng	HCM	y@example.com	0987654321	2022-02-01
3	Lê Văn Z	Kỹ thuật	Đà Nẵng	z@example.com	0765432198	2022-03-01
4	Nguyễn Thị W	Marketing	Hải Phòng	w@example.com	0654321876	2022-04-01
5	Trần Văn V	Hỗ trợ khách hàng	Cần Thơ	v@example.com	0543210987	2022-05-01
\.


--
-- TOC entry 4889 (class 0 OID 16671)
-- Dependencies: 216
-- Data for Name: quyen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.quyen (id_q, phanquyen, ghichu, trangthai) FROM stdin;
1	ADMIN	Tài khoản admin	Active
2	USER	Tài khoản user	Active
3	USER	Tài khoản user bị cấm do boom hàng	Inactive
4	TEST	Tài khoản test	Active
\.


--
-- TOC entry 4897 (class 0 OID 16709)
-- Dependencies: 224
-- Data for Name: sanpham; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.sanpham (id_sp, hinhanh, ten_sp, mausac_sp, loai_sp, id_ncc, soluong_sp, giamd_sp, giakm_sp, hoantra_sp, dvvanchuyen_sp, danhgia_sp, mota_sp) FROM stdin;
1	image1.jpg	Camera A	Đen	Camera	1	10	5000000	4500000	30 ngày	Giao nhanh		\N
2	image2.jpg	Lens B	Trắng	Lens	2	20	2000000	1800000	15 ngày	Giao tiêu chuẩn		\N
3	image3.jpg	Tripod C	Đỏ	Tripod	3	30	1500000	1400000	20 ngày	Giao nhanh		\N
4	image4.jpg	Lighting D	Xanh	Lighting	4	15	2500000	2300000	10 ngày	Giao tiêu chuẩn		\N
5	image5.jpg	Microphone EAS	Vàng	Microphone	5	5	1000000	950000	25 ngày	Giao nhanh		\N
\.


--
-- TOC entry 4891 (class 0 OID 16679)
-- Dependencies: 218
-- Data for Name: taikhoan; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.taikhoan (id_tk, id_q, taikhoan_tk, matkhau_tk, ngaydk_tk) FROM stdin;
1	1	admin	admin123	2023-01-01
2	2	user1	user123	2023-02-01
3	2	user2	user123	2023-03-01
4	3	user3	user123	2023-04-01
5	4	tester1	tester1	2023-05-01
\.


--
-- TOC entry 4909 (class 0 OID 0)
-- Dependencies: 229
-- Name: ctdonhang_id_ctdh_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ctdonhang_id_ctdh_seq', 5, true);


--
-- TOC entry 4910 (class 0 OID 0)
-- Dependencies: 227
-- Name: donhang_id_dh_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.donhang_id_dh_seq', 5, true);


--
-- TOC entry 4911 (class 0 OID 0)
-- Dependencies: 219
-- Name: khachhang_id_kh_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.khachhang_id_kh_seq', 7, true);


--
-- TOC entry 4912 (class 0 OID 0)
-- Dependencies: 221
-- Name: nhacungcap_id_ncc_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nhacungcap_id_ncc_seq', 6, true);


--
-- TOC entry 4913 (class 0 OID 0)
-- Dependencies: 225
-- Name: nhanvien_id_nv_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.nhanvien_id_nv_seq', 7, true);


--
-- TOC entry 4914 (class 0 OID 0)
-- Dependencies: 215
-- Name: quyen_id_q_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.quyen_id_q_seq', 4, true);


--
-- TOC entry 4915 (class 0 OID 0)
-- Dependencies: 223
-- Name: sanpham_id_sp_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sanpham_id_sp_seq', 21, true);


--
-- TOC entry 4916 (class 0 OID 0)
-- Dependencies: 217
-- Name: taikhoan_id_tk_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.taikhoan_id_tk_seq', 5, true);


-- Completed on 2024-10-20 19:25:18

--
-- PostgreSQL database dump complete
--

