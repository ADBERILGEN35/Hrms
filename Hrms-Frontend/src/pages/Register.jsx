
import React from "react";
import { Link, useHistory } from "react-router-dom";
import * as Yup from "yup";
import {
    Button,
    Form,
    Grid,
    Header,
    Image,
    Message,
    Segment,
} from "semantic-ui-react";
import CandidateService from "../services/CandidateService";
import { useFormik } from "formik";

export default function Register() {

    let candidateService = new CandidateService();
    const candidateRegisterSchema = Yup.object().shape({
        birthDate: Yup.date().required("Doğum Tarihi Alanı Zorunludur"),
        email: Yup.string().required("E-Posta Alanı Zorunludur").email("Geçerli Bir E-Posta Adresi Giriniz"),
        reEmail: Yup.string().oneOf([Yup.ref("email"), null], "E-Posta Bilgileri Eşleşmemektedir").required("E-Posta Adresinizi Tekrar Giriniz"),
        firstName: Yup.string().required("İsim Alanı Zorunludur"),
        lastName: Yup.string().required("Soyisim Alanı Zorunludur"),
        nationalNumber: Yup.string().required("Kimlik Numarası Alanı Zorunludur").length(11, "Kımlık Numarası Hatalı").matches(/^[0-9]+$/, "Sadece Rakam Girişi Yapılabilmektedir"),
        password: Yup.string().required("Şifre zorunludur").min(8, "Şifre en az 8 Karakter Uzunlugunda Olmalıdır"),
        rePassword: Yup.string().oneOf([Yup.ref("password"), null], "Şifreler Eşleşmemektedir")
    });

    const history = useHistory();

    const formik = useFormik({
        initialValues: {
            birthDate: "",
            email: "",
            firstName: "",
            lastName: "",
            nationalNumber: "",
            password: "",
            rePassword: "",
        },
        validationSchema: candidateRegisterSchema,
        onSubmit: (values) => {
            console.log(values)
            candidateService.registerCandidate(values).then((result) => alert(result.message))
            history.push("/login")
        }
    });

    const handleChangeSemantic = (value, fieldName) => {
        formik.setFieldValue(fieldName, value);
    }

    return (
        <div>
            <Header as="h2" color="teal" textAlign="center">
                <Image src="data:image/png;base64,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" /> Kayıt Ol
            </Header>
            <Form size="large" onSubmit={formik.handleSubmit}>
                <Segment stacked>
                    <Grid stackable>
                        <Grid.Column width={8}>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>İsim</b></label>

                                <Form.Input
                                    fluid
                                    icon="user"
                                    iconPosition="left"
                                    placeholder="İsim"
                                    type="text"
                                    value={formik.values.firstName}
                                    name="firstName"
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                />
                                {
                                    formik.errors.firstName && formik.touched.firstName && (
                                        <div className={"ui pointing red basic label"}>
                                            {formik.errors.firstName}
                                        </div>
                                    )
                                }
                            </div>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Soy İsim</b></label>
                                <Form.Input
                                    fluid
                                    icon="user"
                                    iconPosition="left"
                                    placeholder="Soyisim"
                                    type="text"
                                    value={formik.values.lastName}
                                    name="lastName"
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                />
                                {formik.errors.lastName && formik.touched.lastName && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.lastName}
                                    </div>
                                )}
                            </div>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Kimlik Numarası</b></label>
                                <Form.Input
                                    fluid
                                    icon="id card"
                                    iconPosition="left"
                                    placeholder="Kimlik Numarası"
                                    type="text"
                                    value={formik.values.nationalNumber}
                                    name="nationalNumber"
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                />
                                {formik.errors.nationalNumber && formik.touched.nationalNumber && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.nationalNumber}
                                    </div>
                                )}
                            </div>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Doğum Tarihi</b></label>
                                <Form.Input
                                    fluid
                                    icon="calendar times"
                                    iconPosition="left"
                                    placeholder="Doğum Tarihi"
                                    type="date"
                                    error={Boolean(formik.errors.birthDate)}
                                    onChange={(event, data) =>
                                        handleChangeSemantic(data.value, "birthDate")
                                    }
                                    value={formik.values.birthDate}
                                    onBlur={formik.handleBlur}
                                    name="birthDate"
                                />
                                {formik.errors.birthDate && formik.touched.birthDate && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.birthDate}
                                    </div>
                                )}
                            </div>
                        </Grid.Column>

                        <Grid.Column width={8}>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Email</b></label>
                                <Form.Input
                                    fluid
                                    icon="mail"
                                    iconPosition="left"
                                    placeholder="E-Posta Adresi"
                                    type="email"
                                    value={formik.values.email}
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                    name="email"
                                />
                                {formik.errors.email && formik.touched.email && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.email}
                                    </div>
                                )}
                            </div>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Email Tekrar</b></label>
                                <Form.Input
                                    fluid
                                    icon="mail"
                                    iconPosition="left"
                                    placeholder="E-Posta Adresi Tekrar"
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                    name="reEmail"
                                />
                                {formik.errors.reEmail && formik.touched.reEmail && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.reEmail}
                                    </div>
                                )}
                            </div>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Şifre</b></label>
                                <Form.Input
                                    fluid
                                    icon="lock"
                                    iconPosition="left"
                                    placeholder="Şifre"
                                    type="password"
                                    value={formik.values.password}
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                    name="password"
                                />
                                {formik.errors.password && formik.touched.password && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.password}
                                    </div>
                                )}
                            </div>
                            <div style={{ marginTop: "1em" }}>
                                <label><b>Şifre Tekrar</b></label>
                                <Form.Input
                                    fluid
                                    icon="lock"
                                    iconPosition="left"
                                    placeholder="Şifre Tekrar"
                                    type="password"
                                    value={formik.values.rePassword}
                                    onChange={formik.handleChange}
                                    onBlur={formik.handleBlur}
                                    name="rePassword"
                                />
                                {formik.errors.rePassword && formik.touched.rePassword && (
                                    <div className={"ui pointing red basic label"}>
                                        {formik.errors.rePassword}
                                    </div>
                                )}
                            </div>
                        </Grid.Column>
                    </Grid>

                    <br />
                    <Button color="teal" fluid size="large" type="submit">
                        Kayıt Ol
                    </Button>
                </Segment>
            </Form>
            <Message info><Link to={"/registerEmployer"}><b>Kurumsal Üyelik İçin Tıklayınız</b></Link></Message>
        </div>
    );
}