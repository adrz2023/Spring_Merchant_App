<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: white;
            margin: 0;
            padding :0;
        }

        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 10px;
            background-color: #fff;
        }

        h2 {
            color: #333;
            border-bottom: 2px solid #ccc;
            padding-bottom: 10px;
            margin-top: 20px;
        }

        a {
            text-decoration: none;
            color: #0066cc;
            display: flex;
            align-items: center;
        }

        a:hover {
            text-decoration: underline;
        }

        i {
            margin-right: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>
        
        
            <a href="open-register"><i class="fas fa-user-plus"></i> Click Here to register Merchant</a>
        </h2>
        <h2>
            <a href="open-update"><i class="fas fa-edit"></i> Click Here to update Merchant</a>
        </h2>
        <h2>
            <a href="open-view?view=findById"><i class="fas fa-search"></i> Click Here to Find Merchant By Id</a>
        </h2>
        <h2>
            <a href="open-view?view=verifyByPhone"><i class="fas fa-mobile-alt"></i> Click Here to Verify Merchant by Phone and Password</a>
        </h2>
        <h2>
            <a href="open-view?view=verifyByEmail"><i class="far fa-envelope"></i> Click Here to Verify Merchant by Email and Password</a>
        </h2>
        <h2>
            <a href="open-view?view=verifyById"><i class="fas fa-id-card"></i> Click Here to Verify Merchant by Id and Password</a>
        </h2>
        <h2>
            <a href="open-view?view=delete"><i class="fas fa-trash-alt"></i> Click Here to delete Merchant by Id</a>
        </h2>
    </div>
</body>
</html>
