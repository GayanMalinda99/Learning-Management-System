
import emaijs from 'emailjs-com'

const Mailer=()=>{
function sendEmail(e) {
    e.preventDefault();
    emaijs.sendForm(
        "service_zv8gg35",
        "template_qx35yym",
        e.target,
        "18N787bwLLxKrb_gs"
        ).then(res=>{
                console.log(res);
        }).catch(err=>console.log(err));
}


    return(

<div className="container border" style={{marginTop:"50px",width:'50',
backgroudImage:`url('https://www.pexels.com/photo/gray-and-white-wallpaper-1103970/')`,
backgroundPosition:'center',
backgroundSize:"cover",


}}>


    <h1 style={{marginTop:'25px'}}>Email Form</h1>

    <form 
     action=""
     className="row" 
     style={{margin:"25px 85px 75px 100px"}}
     onSubmit={sendEmail}
     
     
     >


            <label htmlFor="" >name</label>
            <input className="form-control" type="text" name="name" id="" />

            <label htmlFor="" >email</label>
            <input className="form-control" type="email" name="user_email" id="" />

            <label htmlFor="">Message</label>
            <textarea className="form-control"  name="message" id="" cols="30" rows="10"></textarea>

            <input
             type="submit"
             value="Send" 
             className="form-control btn btn-primary"
             style={{marginTop:"30px"}}
             
             />

    </form>
</div>



    );
}


export default Mailer;