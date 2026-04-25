import {useEffect} from "react";
import axios from "axios";

const Pdf = () =>
{
    useEffect(() => {
        getAllReservations("https://localhost:8080/reservation/pdf");
    }, []);

    const getAllReservations = async (url) =>
    {
        await axios.get(url);
    };

    return(
        <div>
            <h1> Reservations list is generated ad 'reservations_report.pdf' on your Desktop. </h1>
        </div>
    )
}
export default Pdf