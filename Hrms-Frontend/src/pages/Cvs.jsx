import React, { useEffect, useState } from "react";
import { Header, Image, Table, Button, Icon } from "semantic-ui-react";
import CvService from "../services/CvService";

export default function Cvs() {
    const [cvs, setCvs] = useState([]);

    useEffect(() => {
        let cvService = new CvService();
        cvService.getCvs().then((result) => setCvs(result.data.data));
    }, []);

    return (
        <div>
            <Table basic="very" celled collapsing>
                <Table.Header>
                    <Table.Row>
                        <Table.HeaderCell>İş Arayan</Table.HeaderCell>
                        <Table.HeaderCell>Teknolojiler</Table.HeaderCell>
                        <Table.HeaderCell>Diller</Table.HeaderCell>
                        <Table.HeaderCell>Github</Table.HeaderCell>
                        <Table.HeaderCell>Linkedin</Table.HeaderCell>
                        <Table.HeaderCell>Detaylar</Table.HeaderCell>
                    </Table.Row>
                </Table.Header>

                <Table.Body>
                    {cvs.map((cv) => (
                        <Table.Row key={cv.id}>
                            <Table.Cell>
                                <Header as="h4" image>
                                    <Image src={cv.images[0].imageUrl} rounded size="mini" />
                                    <Header.Content>
                                        {cv.candidate.firstName + " " + cv.candidate.lastName}
                                        <Header.Subheader>
                                            {cv.candidate.dateOfBirth}
                                        </Header.Subheader>
                                    </Header.Content>
                                </Header>
                            </Table.Cell>
                            <Table.Cell>
                                {cv.technologies.map((tech) => (
                                    <p>{tech.name}</p>
                                ))}
                            </Table.Cell>

                            <Table.Cell>
                                {cv.languages.map((lang) => (
                                    <p>{lang.name + " Seviye: " + lang.level}</p>
                                ))}
                            </Table.Cell>

                            <Table.Cell>
                                <a href={cv.github}>
                                    <Button secondary>
                                        <Icon name="github" /> Github
                  </Button>
                                </a>
                            </Table.Cell>

                            <Table.Cell>
                                <a href={cv.linkedin}>
                                    <Button color="linkedin">
                                        <Icon name="linkedin" /> LinkedIn
                  </Button>
                                </a>
                            </Table.Cell>

                            <Table.Cell>
                                <Button animated>
                                    <Button.Content visible>Detayları Gör</Button.Content>
                                    <Button.Content hidden>
                                        <Icon name="arrow right" />
                                    </Button.Content>
                                </Button>
                            </Table.Cell>
                        </Table.Row>
                    ))}
                </Table.Body>
            </Table>
        </div>
    );
}